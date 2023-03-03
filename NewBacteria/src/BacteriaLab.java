public class BacteriaLab {
    public static void main(String[] args) {
        // Definiera arrayer som innehåller information om varje bakterie
        String[] bacteriaNamn = {"Bacillus cereus", "Staphylococcus aureus", "Escherichia coli", "Salmonella enterica", "Listeria monocytogenes", "Bakus smällningus"};
        double[] growthRates = {0.3, 0.4, 0.5, 0.6, 0.7, 1.1};
        double[] minGrowthRates = {0.25, 0.35, 0.45, 0.55, 0.65, 1.05};
        double[] maxGrowthRates = {0.35, 0.45, 0.55, 0.65, 0.75, 1.15};
        int[] daysTo50Percentages = {10, 8, 6, 5, 4, 2};

        // Skapa variabler som kommer att användas senare
        String dominantBacteria = null;

        // Loopa igenom varje bakterie och simulerar deras tillväxt
        for (int i = 0; i < bacteriaNamn.length; i++) {
            // Hämta information om nuvarande bakterie
            String bacteria = bacteriaNamn[i];
            double growthRate = growthRates[i];
            double minGrowthRate = minGrowthRates[i];
            double maxGrowthRate = maxGrowthRates[i];
            int daysTo50Percent = daysTo50Percentages[i];
            double highestGrowthRate = 0.0;

            // Skapa variabler för att spåra bakteriepopulationen och tiden
            int days = 0;
            double bacteriaCount = 1;

            // Simulera bakterietillväxt tills en av tre villkor uppfylls
            while (true) {

                // Beräkna dagens tillväxt baserat på bakteriepopulationen och tillväxtfaktorn
                double dailyGrowth = bacteriaCount * (1 + growthRate);
                double growthPercent = dailyGrowth / bacteriaCount;

                //Kolla villkoren för att avbryta körningen / fortsätta till nästa bakterie
                if (bacteriaCount >= 1_000_000_000) {
                    System.out.println(bacteria + " har tagit över labbet!");
                    return;
                } else if (bacteriaCount <= 0.5) {
                    System.out.println(bacteria + " har dött en långsam död!");
                    break;
                } else if (days >= daysTo50Percent) {
                    System.out.println(bacteria + " misslyckades med att nå 50% i tid.");
                    break;
                }else if(growthRate > maxGrowthRate || growthRate < minGrowthRate) {
                    System.out.println(bacteria + " har en tillväxthastighet utanför tillåtet intervall.");
                    return;
                }

                //Skriv ut data om dagens körning
                System.out.println(bacteria + " dag: " + days + ".");
                System.out.println("Tillväxttakt: " + growthPercent + ". Antal bakterier " + bacteriaCount + ".");

                //Uppdatera bacteriaCount med dagens tillväxt inför nästa dag.
                bacteriaCount = bacteriaCount + dailyGrowth;

                //Gå till nästa dag
                days++;
            }
            //Skriv ut lite snygg info när vi går till nästa bakterie.
            // Kolla bara först så det inte är sista loopen (om i + 1 är mindre än array-length är det sista bakterien).
            if(i + 1 < bacteriaNamn.length) {
                System.out.println("-------------------------------------");
                System.out.println("| " + bacteriaNamn[i +1]);
                System.out.println("-------------------------------------");
            }else {
                System.out.println("-------------------------------------");
                System.out.println("-------------------------------------");
            }


            // Uppdatera informationen om den dominerande bakterien,
            // dvs. kolla om den har högre growthRate än den bakterie som hittills haft högst growthRate och ändra i så fall highestGrowthRate.
            if(growthRate > highestGrowthRate){
                dominantBacteria = bacteria;
                highestGrowthRate = growthRate;
            }
        }
    // Skriv ut namnet på den dominerande bakterien
    System.out.println("Dominant bakterie: " + dominantBacteria);
    }
}