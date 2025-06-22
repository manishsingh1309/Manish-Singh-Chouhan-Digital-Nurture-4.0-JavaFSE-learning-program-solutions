import java.util.Scanner;

public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double computeForecast(double amount, double growthRate, int years) {
        if (years == 0) {
            return amount;
        }
        // Compound growth applied recursively
        return computeForecast(amount * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== Financial Forecasting Tool ====");
        
        System.out.print("Enter current investment amount (₹): ");
        double baseAmount = scanner.nextDouble();

        System.out.print("Enter expected annual growth rate (%): ");
        double ratePercent = scanner.nextDouble();
        double rateDecimal = ratePercent / 100.0;

        System.out.print("Enter the number of years for forecasting: ");
        int forecastYears = scanner.nextInt();

        double predictedValue = computeForecast(baseAmount, rateDecimal, forecastYears);

        System.out.printf("\n📊 Predicted amount after %d years: ₹%.2f\n", forecastYears, predictedValue);

        scanner.close();
    }
}
