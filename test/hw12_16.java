public class hw13_4 {
  /** 主程式 */
  public static void main(String[] args) {
    // 提示使用者輸入月份和年份
    int month = Integer.parseInt(args[0]);
    int year = Integer.parseInt(args[1]);

    // 印出該年份月份的日曆
    printMonth(year, month);
  }

  /** 印出特定年份和月份的日曆 */
  public static void printMonth(int year, int month) {
    // 印出月份標題
    printMonthTitle(year, month);

    // 印出月份的日曆內容
    printMonthBody(year, month);
  }

  /** 印出月份標題，例如：May 1999 */
  public static void printMonthTitle(int year, int month) {
    System.out.println("         " + getMonthName(month)
      + " " + year);
    System.out.println("-----------------------------");
    System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
  }

  /** 根據數字取得對應的英文月份名稱 */
  public static String getMonthName(int month) {
    String monthName = "";
    switch (month) {
      case 1: monthName = "January"; break;
      case 2: monthName = "February"; break;
      case 3: monthName = "March"; break;
      case 4: monthName = "April"; break;
      case 5: monthName = "May"; break;
      case 6: monthName = "June"; break;
      case 7: monthName = "July"; break;
      case 8: monthName = "August"; break;
      case 9: monthName = "September"; break;
      case 10: monthName = "October"; break;
      case 11: monthName = "November"; break;
      case 12: monthName = "December";
    }

    return monthName;
  }

  /** 印出日曆的內容 */
  public static void printMonthBody(int year, int month) {
    // 取得該月份第一天是星期幾
    int startDay = getStartDay(year, month);

    // 取得該月份有多少天
    int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

    // 在該月份的第一天前先印出空格
    int i = 0;
    for (i = 0; i < startDay; i++)
      System.out.print("    ");

    // 印出每一天的日期
    for (i = 1; i <= numberOfDaysInMonth; i++) {
      System.out.printf("%4d", i);

      // 每當一行滿七天就換行
      if ((i + startDay) % 7 == 0)
        System.out.println();
    }

    System.out.println();
  }

  /** 取得該年份該月份第一天是星期幾 */
  public static int getStartDay(int year, int month) {
    final int START_DAY_FOR_JAN_1_1800 = 3;
    // 計算從 1800 年 1 月 1 日到該月 1 日的總天數
    int totalNumberOfDays = getTotalNumberOfDays(year, month);

    // 回傳該月第一天是星期幾
    return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
  }

  /** 計算從 1800 年 1 月 1 日到該年該月的總天數 */
  public static int getTotalNumberOfDays(int year, int month) {
    int total = 0;

    // 計算從 1800 年到該年 1 月 1 日的總天數
    for (int i = 1800; i < year; i++)
      if (isLeapYear(i))
        total = total + 366;  // 閏年
      else
        total = total + 365;  // 平年

    // 計算從該年 1 月 1 日到該月前一天的天數
    for (int i = 1; i < month; i++)
      total = total + getNumberOfDaysInMonth(year, i);

    return total;
  }

  /** 取得該月份的天數 */
  public static int getNumberOfDaysInMonth(int year, int month) {
    // 大月，31天
    if (month == 1 || month == 3 || month == 5 || month == 7 ||
      month == 8 || month == 10 || month == 12)
      return 31;

    // 小月，30天
    if (month == 4 || month == 6 || month == 9 || month == 11)
      return 30;

    // 2 月，平年 28 天，閏年 29 天
    if (month == 2) return isLeapYear(year) ? 29 : 28;

    return 0; // 如果月份不正確，回傳 0
  }

  /** 判斷是否為閏年 */
  public static boolean isLeapYear(int year) {
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
  }
}
