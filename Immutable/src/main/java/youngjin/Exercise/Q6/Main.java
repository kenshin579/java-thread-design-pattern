package youngjin.Exercise.Q6;

public class Main {
    public static void main(String[] args) {
        ImmutablePerson immutablePerson = new ImmutablePerson("iFrank", "iKorea");
//         MutablePerson mutablePerson = new MutablePerson("mFrank", "mKorea");
        MutablePerson mutablePerson = new MutablePerson(immutablePerson);


    }
}
