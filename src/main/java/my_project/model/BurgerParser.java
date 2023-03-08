package my_project.model;

public class BurgerParser implements Parser{
    private final BurgerScanner scanner;

    public BurgerParser() {
        scanner = new BurgerScanner();
    }
    @Override
    public boolean parse(String input) {
        if(scanner.scan(input)) {
            if (scanner.getType().equals("unten")) {
                scanner.nextToken();
                int i = 0;
                while(scanner.getType().equals("mitte") && i <= 3) {
                    scanner.nextToken();
                    i++;
                }
                if(scanner.getType().equals("oben") && i <= 3 && i >= 1) {
                    scanner.nextToken();
                    return scanner.getType().equals("NODATA");
                }
            }
        }
        return false;
    }

    @Override
    public boolean getScannerResult(String input) {
        return scanner.scan(input);
    }

    public String getScannerOutput() {
        return scanner.getDebugOutput();
    }
}
