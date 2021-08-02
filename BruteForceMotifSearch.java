public class BruteForceMotifSearch {
    static String consensus = "acgtacgt";

    public static void main(String[] args) {
        String dna[] = {"cctgatagacgctatctggctatccaggtacttaggtcctctgtgcgaatctatgcgtttccaaccat",
                "agtactggtgtacatttgatccatacgtacaccggcaacctgaaacaaacgctcagaaccagaagtgc",
                "aaacgttagtgcaccctctttcttcgtggctctggccaacgagggctgatgtataagacgaaaatttt",
                "agcctccgatgtaagtcatagctgtaactattacctgccacccctattacatcttacgtccatataca",
                "ctgttatacaacgcgtcatggcggggtatgcgttttggtcgtcgtacgctcgatcgttaccgtacggc"};

        int n = dna[0].length();
        int t = dna.length;

        bruteForce(dna, t, n, consensus.length());
    }


    public static void bruteForce(String[] dna, int t, int n, int l) {
        int[] bestScores = new int[t];
        int[] bestMotifs = new int[t];

        for (int i = 0; i < dna.length; i++) {

            for (int j = 0; j < n - l + 1; j++) {
                int score = score(dna[i], j);
                if (score > bestScores[i]) {
                    bestScores[i] = score;
                    bestMotifs[i] = j;
                }
            }
        }

        int totalScore = 0;
        for (int i = 0; i < bestScores.length; i++) {
            System.out.println("DNA : " + dna[i]);
            System.out.println("Starting Position : " + (bestMotifs[i] + 1));
            System.out.println("Pattern Found : " + dna[i].substring(bestMotifs[i], bestMotifs[i] + consensus.length()));
            totalScore += bestScores[i];
        }
        System.out.println("Best Score : " + totalScore);
    }


    public static int score(String dna, int s) {
        String dnaSegment = dna.substring(s, s + consensus.length());
        int score = 0;
        for (int i = 0; i < dnaSegment.length(); i++) {
            if (dnaSegment.charAt(i) == consensus.charAt(i)) {
                score++;
            }
        }
        return score;
    }


}