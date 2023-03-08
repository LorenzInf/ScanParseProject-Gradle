package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;

public class BurgerScanner extends Scanner<String,String>{

    private StringBuilder debugOutput;

    @Override
    public boolean scan(String input) {
        debugOutput = new StringBuilder();
        debugOutput.append("\nScanner recognized following tokens:\n");
        if(input == null || input.length() == 0){
            debugOutput.append("Sorry, can't scan empty String.");
            return false;
        }
        this.tokenList = new List<>();
        int i = 0;
        while(i < input.length()) {
            int tokenLength = 0;
            if(input.startsWith("brou")) {
                tokenList.append(new Token<String, String>("brou", "unten"));
                debugOutput.append("unten > ");
                tokenLength = 4;
            } else if(input.startsWith("salat")) {
                tokenList.append(new Token<String, String>("salat","mitte"));
                debugOutput.append("mitte > ");
                tokenLength = 5;
            } else if(input.startsWith("kaese")) {
                tokenList.append(new Token<String, String>("kaese","mitte"));
                debugOutput.append("mitte > ");
                tokenLength = 5;
            } else if(input.startsWith("fleisch")) {
                tokenList.append(new Token<String, String>("fleisch","mitte"));
                debugOutput.append("mitte > ");
                tokenLength = 7;
            } else if(input.startsWith("tomate")) {
                tokenList.append(new Token<String, String>("tomate","mitte"));
                debugOutput.append("mitte > ");
                tokenLength = 6;
            } else if(input.startsWith("gurke")) {
                tokenList.append(new Token<String, String>("gurke","mitte"));
                debugOutput.append("mitte > ");
                tokenLength = 5;
            } else if(input.startsWith("sosse")) {
                tokenList.append(new Token<String, String>("sosse","mitte"));
                debugOutput.append("mitte > ");
                tokenLength = 5;
            } else if(input.startsWith("broo")) {
                tokenList.append(new Token<String, String>("broo","oben"));
                debugOutput.append("oben > ");
                tokenLength = 4;
            } else return false;
            input = input.substring(i + tokenLength);
        }
        this.tokenList.append(new Token<String,String>("#","NODATA"));
        tokenList.toFirst(); // WICHTIG!
        return true;
    }

    public String getDebugOutput() {
        return debugOutput.toString();
    }
}
