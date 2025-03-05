//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class TestAtf {
//
//    private String userName;
//    private String userAction;
//    private Integer userMoney;
//
//    public TestAtf(String userName, String userAction, Integer userMoney) {
//        this.userName = userName;
//        this.userAction = userAction;
//        this.userMoney = userMoney;
//    }
//
//    public static void main(String[] args) {
//        TestAtf testAtf = new TestAtf("Pedro", "PrintMoney", 25_020);
//
//        // Используем LinkedHashMap, чтобы сохранить порядок (от большего к меньшему)
//        Map<String, Integer> nominals = new LinkedHashMap<>();
//        nominals.put("20k", 20_000);
//        nominals.put("10k", 10_000);
//        nominals.put("5k", 5_000);
//        nominals.put("2k", 2_000);
//        nominals.put("1k", 1_000);
//
//        if (testAtf.userAction.equals("PrintMoney") && testAtf.userMoney != null) {
//            int remainingMoney = testAtf.userMoney;
//            System.out.println(testAtf.userName + " asking " + testAtf.userMoney + " KZT:");
//
//            for (Map.Entry<String, Integer> entry : nominals.entrySet()) {
//                int billValue = entry.getValue();
//                int nominalCount = remainingMoney / billValue; // Считаем, сколько купюр этого номинала выдать
//
//                if (nominalCount > 0) {
//                    System.out.println(entry.getKey() + " x " + nominalCount); // Вывод количества купюр
//                    remainingMoney -= nominalCount * billValue; // Вычитаем выданные деньги
//                }
//            }
//
//            if (remainingMoney > 0) {
//                System.out.println("Не удалось выдать оставшиеся " + remainingMoney + " KZT.");
//            }
//        }
//    }
//}
