public class CaesarCipher {
    public static void main(String[] args) {
        String test = "The quick brown fox jumps over the lazy dog";
        test = encode(test, 3);
        System.out.println(test);
        test = decode(test,3);
        System.out.println(test);
    }
    public static String encode(String plainText, int key){
        String code = ""; //string to be coded
        for (int i = 0; i < plainText.length(); i++) {
            char uncodedChar = plainText.charAt(i);
            if(Character.isLetter(uncodedChar)){
                //if it is a character, code before adding
                char codedChar;
                char base;
                if(Character.isUpperCase(uncodedChar)){
                    base = 'A';
                }else{
                    base = 'a';
                }
                codedChar = (char)((uncodedChar-base+key)%26 + base);//code the char
                code = code + codedChar;//add coded char
            }else{
                code = code + uncodedChar;//add uncoded char
            }
        }
        return code;
    }
    public static String decode(String cipherText, int key){
        String decoded = ""; //string to be decoded
        for (int i = 0; i < cipherText.length(); i++) {
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
                decodedChar = (char)((codedChar-base-key + 26)%26 + base);//decode the char
                decoded = decoded + decodedChar;//add decoded char
            }else{
                decoded = decoded + codedChar;//add unchanged char
            }
        }
        return decoded;
    }

}
