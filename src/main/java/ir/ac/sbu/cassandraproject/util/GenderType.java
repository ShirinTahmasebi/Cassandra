package ir.ac.sbu.redisproject.util;

public class GenderType {

    public enum Gender {

        NOTDEFINED,
        FEMALE,
        MALE
    }

    public static int getGenderCode(Gender g) {
        switch (g) {
            case NOTDEFINED:
                return 0;
            case MALE:
                return 2;
            case FEMALE:
                return 1;
            default:
                return 0;
        }

    }

    public static String getGenderString(Gender g) {
        switch (g) {
            case NOTDEFINED:
                return "نا مشخض";
            case MALE:
                return "مرد ";
            case FEMALE:
                return "زن";
            default:
                return "نا مشخض";
        }
    }

    public static String getGenderString(int g) {
        switch (g) {
            case 0:
                return "نا مشخض";
            case 2:
                return "مرد ";
            case 1:
                return "زن";
            default:
                return "نا مشخض";
        }
    }

    public static Gender getGenderType(int g) {
        switch (g) {
            case 0:
                return Gender.NOTDEFINED;
            case 1:
                return Gender.FEMALE;
            case 2:
                return Gender.MALE;
            default:
                return Gender.NOTDEFINED;
        }
    }

}
