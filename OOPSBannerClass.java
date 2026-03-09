public class OOPSBannerClass
{

    static class CharacterPatternMap {
        Character character;
        String[] pattern;

        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public Character getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    public static CharacterPatternMap[] createCharacterPatternMaps() {
        CharacterPatternMap[] characterPatternMap = new CharacterPatternMap[4];

        String[] oPattern = {
            "  *****  ",
            " ******* ",
            "**     **",
            "**     **",
            "**     **",
            " ******* ",
            "  *****  "
        };

        String[] pPattern = {
            " ******* ",
            "**     **",
            "**     **",
            "******** ",
            "**       ",
            "**       ",
            "**       "
        };

        String[] sPattern = {
            " ********",
            "**     **",
            "**       ",
            " ******* ",
            "       **",
            "**     **",
            "******** "
        };

        String[] spacePattern = {
            "         ",
            "         ",
            "         ",
            "         ",
            "         ",
            "         ",
            "         "
        };

        characterPatternMap[0] = new CharacterPatternMap('O', oPattern);
        characterPatternMap[1] = new CharacterPatternMap('P', pPattern);
        characterPatternMap[2] = new CharacterPatternMap('S', sPattern);
        characterPatternMap[3] = new CharacterPatternMap(' ', spacePattern);

        return characterPatternMap;
    }

    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }
        
        if (ch != ' ') {
            return getCharacterPattern(' ', charMaps);
        }
        
        return new String[7];
    }

    public static void printMessage(String message, CharacterPatternMap[] charMaps) {
        int patternHeight = 7;
        message = message.toUpperCase();

        for (int i = 0; i < patternHeight; i++) {
            StringBuilder currentLine = new StringBuilder();
            
            for (int j = 0; j < message.length(); j++) {
                char ch = message.charAt(j);
                String[] charPattern = getCharacterPattern(ch, charMaps);
                
                currentLine.append(charPattern[i]);
                
                if (j < message.length() - 1) {
                    currentLine.append("   ");
                }
            }
            System.out.println(currentLine.toString());
        }
    }

    public static void main(String[] args) {
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();
        printMessage("OOPS", charMaps);
    }
}