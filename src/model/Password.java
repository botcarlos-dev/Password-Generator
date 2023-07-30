package model;

public class Password {

    String Value;
    int Length;

    public Password(String s) {
        Value = s;
        Length = s.length();
    }

    public int CharType(char C) {
        int val;

        //Char is Upper Case
        if ((int) C >= 65 && (int) C <= 90)
            val = 1;

            //Char is Lower Case
        else if ((int) C >= 97 && (int) C <= 122) {
            val = 2;
        }

        //Char is Number
        else if ((int) C >= 48 && (int) C <= 57) {
            val = 3;
        }

        //Char is Symbol
        else {
            val = 4;
        }
        return val;
    }

    public int PasswordStrength() {
        String s = this.Value;
        boolean UsedUpper = false;
        boolean UsedLower = false;
        boolean UsedNumber = false;
        boolean UsedSymbol = false;
        int type;
        int Score = 0;

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            type = CharType(c);

            if (type == 1) UsedUpper = true;
            if (type == 2) UsedLower = true;
            if (type == 3) UsedNumber = true;
            if (type == 4) UsedSymbol = true;
        }

        if (UsedUpper) Score += 1;
        if (UsedLower) Score += 1;
        if (UsedNumber) Score += 1;
        if (UsedSymbol) Score += 1;

        if (s.length() >= 8) Score += 1;
        if (s.length() >= 16) Score += 1;

        return Score;
    }

    public String calculateScore() {
        int Score = this.PasswordStrength();

        if (Score == 6) {
            return "Very Strong";
        }
        else if (Score == 4) {
            return "Strong";
        }
        else if (Score == 3) {
            return "Moderate";
        }
        else {
            return "Weak";
        }
    }

    @Override
    public String toString() {
        return Value;
    }
}
