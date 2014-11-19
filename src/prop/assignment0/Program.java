package prop.assignment0;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Program {
	public static void main(String[] args) {
		String inputFileName = null;
		String outputFileName = null;
		IParser parser = null;
		INode root = null; // Root of the parse tree.
		StringBuilder builder = null;
		FileOutputStream stream = null;
		OutputStreamWriter writer = null;

		try {
			try {
				/* Uncomment if want grade A or B
				if (args.length < 2)
					throw new Exception("Incorrect number of parameters to program.");
				
				inputFileName = args[0];
				outputFileName = args[1];
				*/
				
				// TODO: check if System.getProperty works // seems to work
				inputFileName = System.getProperty("user.dir") + "/input-output-files/program1.txt";
				outputFileName = System.getProperty("user.dir") + "/input-output-files/output.txt";
				parser = new Parser();
				parser.open(inputFileName);
				System.out.println("1# Program");
				root = parser.parse();
				System.out.println("2# Program");
				builder = new StringBuilder();
				builder.append("PARSE TREE:\n");
				System.out.println("3# Program");
				root.buildString(builder, 0);
				System.out.println("4# Program");
				builder.append("\nEVALUATION:\n");
				builder.append(root.evaluate(null));

				System.out.println("5# Program");
				
				stream = new FileOutputStream(outputFileName);
				writer = new OutputStreamWriter(stream);
				writer.write(builder.toString());
			
				System.out.println("6# Program");
			}
			catch (Exception exception) {
				System.out.println("EXCEPTION: " + exception);
			}
			finally {
				System.out.println("7# Program");
				if (parser != null)
					parser.close();
				if (writer != null)
					writer.close();
				if (stream != null)
					stream.close();
				System.out.println("8# Program");
			}
		}
		catch (Exception exception) {
			System.out.println("EXCEPTION: " + exception);
		}
	}
}
