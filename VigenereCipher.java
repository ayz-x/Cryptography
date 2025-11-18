public class VigenereCipher {
    public static void main(String[] args) {
        String test = "The quick brown fox jumps over the lazy dog";
        test = encode(test, "sigma");
        System.out.println(test);
        test = decode(test, "sigma");
        System.out.println(test);
    }
    //precondition: keyword is all lowercase and all characters
    public static String encode(String plainText, String keyword){
        String code = ""; //string to be coded
        for (int i = 0; i < plainText.length(); i++) {
            char uncodedChar = plainText.charAt(i);
            int key = keyword.charAt(i%keyword.length()) - 'a';
            if(Character.isLetter(uncodedChar)){
                //if it is a character, code before adding
                char codedChar;
                char base;
                if(Character.isUpperCase(uncodedChar)){
                    base = 'A';
                }else{
                    base = 'a';
                }
                codedChar = (char)((uncodedChar-base+key)%26 + base); //code the char
                code = code + codedChar; //add new coded char
            }else{
                code = code + uncodedChar; //add uncoded char
            }
        }
        return code;
    }
    //precondition: keyword is all lowercase and all characters
    public static String decode(String cipherText, String keyword){
        String decoded = ""; //string to be decoded
        for (int i = 0; i < cipherText.length(); i++) {
            int key = keyword.charAt(i%keyword.length()) -'a';
            char codedChar = cipherText.charAt(i);
            if(Character.isLetter(codedChar)){
                //if it is a character, decode before adding
                char decodedChar;
                char base;
                if(Character.isUpperCase(codedChar)){
                    base = 'A';
                }else{
                    base = 'a';
                }
                decodedChar = (char)((codedChar-base-key + 26)%26 + base); //decode the char
                decoded = decoded + decodedChar; //add new decoded char
            }else{
                decoded = decoded + codedChar; //not a character, just add
            }
        }
        return decoded;
    }
}
