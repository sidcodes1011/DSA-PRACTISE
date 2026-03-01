class islandDaySurvival {

    static int minimumDays(int S, int N, int M) {
        
        // If daily need is more than maximum purchase per day
        if (M > N) return -1;
        // Weekly survival condition
        if (S > 6 && (6 * N < 7 * M)) return -1;
        int totalFood = S * M;
        // Minimum buying days (ceiling division)
        return (totalFood + N - 1) / N;
    }

    public static void main(String[] args) {
        
        int S = 10;  // Days to survive
        int N = 16;   // Max food per day
        int M = 2;   // Food required per day
        int result = minimumDays(S, N, M);
        
        System.out.println("Minimum days required to buy food: " + result);
    }
}
