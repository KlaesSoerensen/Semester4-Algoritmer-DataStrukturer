package ExamTools;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/*
Explanation of Relationships between Time Complexities:

1. Tends to infinity:
   If the ratio of runtimes tends to infinity as n grows, it means that the numerator grows faster than the denominator,
   indicating that the algorithm in the numerator has a higher time complexity. Symbolically,
   lim(n → ∞) (f(n) / g(n)) = ∞ implies f(n) = Ω(g(n)).

2. Tends to a constant:
   If the ratio of runtimes tends to a constant as n grows, it means that both algorithms have the same order of growth.
   Symbolically, lim(n → ∞) (f(n) / g(n)) = c (where c is a constant) implies f(n) = Θ(g(n)).

3. Tends to zero:
   If the ratio of runtimes tends to zero as n grows, it means that the denominator grows faster than the numerator,
   indicating that the algorithm in the numerator has a lower time complexity. Symbolically,
   lim(n → ∞) (f(n) / g(n)) = 0 implies f(n) = O(g(n)).

In each case, f(n) represents the time complexity of the algorithm in the numerator, and g(n) represents the time complexity
of the algorithm in the denominator.
*/

public class AlgorithmComparison {
    public AlgorithmComparison() {

    }

    public String compare(String fn, String gn, long loops) {

        for (int i = 0; i < loops; i++) {
            Expression expression = new ExpressionBuilder(fn.replace("n", "" + i)
                    + "/"
                    + gn.replace("n", "" + i)).build();

            System.out.println(expression.evaluate());
        }


        return null;
    }

}
