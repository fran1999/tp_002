package ar.edu.unlp.info.oo2.tp.roo2;

public class ColumnarTranspositionCipher implements Cipher{
	char [] keyword;
	final static String DEFAULT_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String alphabet;
	int numOfRows;
	
	public ColumnarTranspositionCipher(String keyword){
		this.keyword = keyword.toCharArray();
		this.alphabet = DEFAULT_ALPHABET;
	}
	
	
    private int[] keywordOrder(char[] keyword) {
        int[] keywordOrderList = new int[keyword.length];

        int count = 0;
        for (int i = 0; i < this.alphabet.length(); i ++){
            for (int j = 0; j < keyword.length; j++) {
                if (this.alphabet.charAt(i) == keyword[j]){
                    count++;
                    keywordOrderList[j] = count;
                }
            } // inner for
        } // for
        return keywordOrderList;
    }
    
    private StringBuilder fillBlanks(StringBuilder msg) {
        // in case characters don't fit the entire grid perfectly.
        int extraLetters = msg.length() % keyword.length;
        //System.out.println(extraLetters);
        int dummyCharacters = keyword.length - extraLetters;
//        System.out.println(dummyCharacters);

        if (extraLetters != 0){
            for (int i = 0; i < dummyCharacters; i++) {
                msg.append("*");
            }
        }
        return msg;
    }
    
	private char[][] calculateMatrix(String inputText) {
		StringBuilder msg = new StringBuilder(inputText.replace(" ", ""));
		msg = this.fillBlanks(msg);
		int[] keywordOrderList = this.keywordOrder(this.keyword);
        this.numOfRows = msg.length() / keyword.length;
        // Converting message into a grid
        char[][] matrix = new char[this.numOfRows][keyword.length];
        int letterIndex = 0;
        for (int row = 0; row < this.numOfRows; row++) {
            for (int col = 0; col < keyword.length; col++) {
                matrix[row][col] = msg.charAt(letterIndex);
                letterIndex++;
            }
        }
        return matrix;
	}
	
	private char[][] orderColumns(char [] keyword,String numberLocation,char [][]matrix) {
		char [][] result = new char[matrix.length][keyword.length];
			for (int i = 0; i < this.numOfRows; i++) {
				System.out.println("i: "+ i);
				int col;
				if(i == keyword.length)
					break;
				else {
						col = Character.getNumericValue(numberLocation.charAt(i));
					}
					
	            for (int j = 0; j < this.numOfRows; j++) {
	            	result[j][i] = matrix[j][col];
	            }
			}
			return result;
	}
	
	private String cipherWord(char [][]matrix){
		StringBuilder result = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
            	result.append(matrix [i][j]);
            }
        }
		return result.toString();
	}
	
    private String getNumberLocation(char[] keyword, int[] kywrdNumList) {
        String numLoc = "";
        for (int i = 1; i < keyword.length + 1; i++) {
            for (int j = 0; j < keyword.length; j++) {
                if (kywrdNumList[j] == i){
                    numLoc += j;
                }
            }
        }
        return numLoc;
    } // getting number location function
    
    public static void print2D(char mat[][])
    {
        // Loop through all rows
        for (char[] row : mat)
 
            // converting each row as string
            // and then printing in a separate line
            System.out.println((row));
    }
	@Override
	public String cipher(String inputText) {
		// TODO Auto-generated method stub
		char[][] matrix = calculateMatrix(inputText);
		print2D(matrix);
		int[] keywordOrderList = this.keywordOrder(this.keyword);
		String numberLocation = this.getNumberLocation(this.keyword, keywordOrderList);
		char [][] reOrderedMatrix = this.orderColumns(this.keyword, numberLocation, matrix);
		print2D(reOrderedMatrix);
		return this.cipherWord(reOrderedMatrix);
	}

	@Override
	public String decipher(String inputText) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
