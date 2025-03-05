//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class TestAtfV2 {
//
//    private String userName;
//    private String userAction;
//    private Integer userMoney;
//
//    public TestAtfV2(String userName, String userAction, Integer userMoney) {
//        this.userName = userName;
//        this.userAction = userAction;
//        this.userMoney = userMoney;
//    }
//
//    public static void main(String[] args) {
//        TestAtfV2 testAtfV2 = new TestAtfV2("Pedro", "PrintMoney", 25_020);
//
//        // Используем LinkedHashMap, чтобы сохранить порядок (от большего к меньшему)
//        Map<Integer, Integer> atmBanknotes = new LinkedHashMap<>();
//        atmBanknotes.put(20_000, 20);
//        atmBanknotes.put(10_000, 15);
//        atmBanknotes.put(5_000, 10);
//        atmBanknotes.put(2_000, 10);
//        atmBanknotes.put(1_000, 10);
//
//
//        if (testAtfV2.userAction.equals("PrintMoney") && testAtfV2.userMoney != null) {
//            int remainingMoney = testAtfV2.userMoney;
//            Map<Integer, Integer> issuedBanknotes = new LinkedHashMap<>();
//            System.out.println(testAtfV2.userName + " запрашивает " + testAtfV2.userMoney + " KZT:");
//
//
//            for (Map.Entry<Integer, Integer> entry : atmBanknotes.entrySet()) {
//                int billValue = entry.getKey();
//                int billCount = entry.getValue();
//                int neededBills = remainingMoney / billValue; // Сколько купюр нужно
//                int givenBills = Math.min(neededBills, billCount); // Сколько реально можно выдать
//
//                if (givenBills > 0) {
//                    issuedBanknotes.put(billValue, givenBills);
//                    remainingMoney -= givenBills * billValue;
//                    atmBanknotes.put(billValue, billCount - givenBills); // Обновляем банк в банкомате
//                }
//            }
//
//
//
//            if (!issuedBanknotes.isEmpty()){
//                System.out.println("Выдано:");
//                for (Map.Entry<Integer, Integer> entry : issuedBanknotes.entrySet()) {
//                    System.out.println(entry.getKey() + " KZT x " + entry.getValue());
//                }
//            }
//
//            if (remainingMoney > 0) {
//                System.out.println("Не удалось выдать оставшиеся " + remainingMoney + " KZT.");
//            }
//
//            System.out.println("\nОставшиеся деньги в банкомате:");
//            for (Map.Entry<Integer, Integer> entry : atmBanknotes.entrySet()) {
//                System.out.println(entry.getKey() + " KZT → " + entry.getValue() + " купюр");
//            }
//        }
//    }
//}
