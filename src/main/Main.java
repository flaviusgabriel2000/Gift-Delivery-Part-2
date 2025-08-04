package main;

import checker.Checker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import common.Constants;
import solver.database.Database;
import solver.simulate.Simulator;
import solver.simulate.output.Output;
import solver.simulate.strategies.simulationstrategy.AnnualStrategy;
import solver.simulate.strategies.simulationstrategy.RoundZeroStrategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());

        for (int i = 1; i <= Constants.TESTS_NUMBER; i++) {
            byte[] jsonData = Files.readAllBytes(Paths
                    .get(Constants.INPUT_PATH + i + Constants.FILE_EXTENSION));
            Database database = objectMapper.readValue(jsonData, Database.class);

            Simulator simulator = new Simulator(database);
            Output output = Output.getInstance();

            simulator.simulate(new RoundZeroStrategy(output));

            File file = new File(Constants.OUTPUT_PATH + i + Constants.FILE_EXTENSION);
            try {
                JsonGenerator g = objectMapper.getFactory()
                        .createGenerator(new FileOutputStream(file));
                for (int j = 0; j < database.getNumberOfYears(); j++) {
                    simulator.simulate(new AnnualStrategy(output,
                            database.getAnnualChanges().get(j), database,
                            database.getAnnualChanges().get(j).getStrategy()));
                }
                objectWriter.writeValue(g, output);
                g.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            output.clearAnnualChildren();
        }
        Checker.calculateScore();
    }
}
