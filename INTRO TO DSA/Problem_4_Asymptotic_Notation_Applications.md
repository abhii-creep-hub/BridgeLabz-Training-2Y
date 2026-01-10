# Problem 4: Asymptotic Notation Applications

### Scenario
A data analytics company is evaluating different sorting algorithms for their big data processing pipeline.

### Solutions

#### a) Formal Proofs of Worst-Case Complexity

**Bubble Sort: O(n²)**

We need to show: T(n) ≤ c × n² for n ≥ n₀

In worst case (reverse sorted), Bubble Sort makes:
- Pass 1: (n-1) comparisons
- Pass 2: (n-2) comparisons
- ...
- Pass (n-1): 1 comparison

Total comparisons: (n-1) + (n-2) + ... + 1 = n(n-1)/2 = (n² - n)/2

For n ≥ 2: (n² - n)/2 ≤ n²/2

Choose c = 1/2 and n₀ = 2
Then: T(n) = (n² - n)/2 ≤ (1/2) × n² for all n ≥ 2

Therefore, Bubble Sort is O(n²).

**Merge Sort: Θ(n log n)**

We need to show: c₁ × n log n ≤ T(n) ≤ c₂ × n log n for n ≥ n₀

Merge Sort recurrence: T(n) = 2T(n/2) + n

Solving using Master Theorem:
- a = 2, b = 2, f(n) = n
- n^(log_b a) = n^(log₂ 2) = n
- f(n) = n = Θ(n), so case 2 applies
- T(n) = Θ(n log n)

For upper bound: T(n) ≤ c₂ × n log n
For lower bound: T(n) ≥ c₁ × n log n

Choose c₁ = 1, c₂ = 2, n₀ = 2
Therefore, Merge Sort is Θ(n log n).

#### b) Algorithm Selection by Data Type

**Type A: Nearly Sorted Data (90% in order)**
- Best choice: **Insertion Sort**
- Reason: O(n) best case when data is nearly sorted
- Insertion Sort excels when elements are close to their final positions

**Type B: Completely Random Data**
- Best choice: **Quick Sort** (average case) or **Merge Sort**
- Reason: Both have O(n log n) average case
- Quick Sort is often faster in practice due to better cache performance
- Merge Sort provides guaranteed O(n log n) in all cases

**Type C: Reverse Sorted Data (worst ordering)**
- Best choice: **Merge Sort**
- Reason: Maintains Θ(n log n) regardless of input
- Quick Sort degrades to O(n²) on reverse sorted data
- Bubble Sort and Insertion Sort also degrade to O(n²)

#### c) Merge Sort Θ(n log n) vs Quick Sort O(n log n)

**Merge Sort: Θ(n log n)**
- Uses Theta notation because it has the same complexity in all cases
- Best case: Θ(n log n)
- Average case: Θ(n log n)
- Worst case: Θ(n log n)
- Tight bound applies in all scenarios

**Quick Sort: O(n log n) average**
- Uses Big-O because worst case is different
- Best case: O(n log n)
- Average case: O(n log n)
- Worst case: O(n²)
- Big-O represents upper bound; worst case exceeds n log n

The difference: Merge Sort has consistent performance, while Quick Sort can degrade to quadratic time in worst case.

#### d) Decision Tree for Algorithm Selection

```
                    Data Size?
                   /           \
            Small (n<50)    Medium/Large (n≥50)
                 |                    |
            Nearly Sorted?        Data Characteristics?
            /          \          /        |        \
          Yes          No      Sorted   Random   Reverse
           |           |         |         |         |
    Insertion Sort  Insertion  Any      Quick    Merge
    (O(n))          Sort       O(n²)    Sort     Sort
                    (O(n²))             (avg)    (Θ(n log n))
                                        O(n log n)
```

**Justifications:**

**Small datasets (n < 50):**
- Overhead of O(n log n) algorithms may exceed benefits
- Insertion Sort is simple and efficient for small n
- Even O(n²) is acceptable when n is small

**Medium/Large datasets (n ≥ 50):**

**Sorted data:**
- Any algorithm works, but Insertion Sort is O(n) for sorted input
- However, for large n, Merge/Quick Sort still reasonable

**Random data:**
- Quick Sort preferred for average O(n log n) and good cache performance
- Merge Sort alternative if stability needed

**Reverse sorted:**
- Merge Sort essential to avoid O(n²) degradation
- Guaranteed Θ(n log n) performance

#### e) Mystery Sort vs Merge Sort Comparison

**Mystery Sort:** T(n) = 5n² + 100n + 1000
**Merge Sort:** T(n) = 10n log₂ n

We need to find when: 5n² + 100n + 1000 < 10n log₂ n

Rearranging: 5n² + 100n + 1000 - 10n log₂ n < 0

For small n, Mystery Sort may be faster due to lower constant factors.
For large n, Merge Sort dominates due to n log n vs n² growth.

**Solving numerically:**

For n = 1: Mystery = 1105, Merge = 0 (undefined, but assume 10)
For n = 10: Mystery = 6100, Merge ≈ 33.2 → Merge faster
For n = 2: Mystery = 1220, Merge ≈ 6.6 → Merge faster

Actually, let's solve: 5n² + 100n + 1000 = 10n log₂ n

This is transcendental. Using approximation:

For very small n (n < 3), Mystery Sort might be faster, but:
- n = 1: Not meaningful for sorting
- n = 2: Both are essentially constant time

**Conclusion:**
Mystery Sort is never practically faster than Merge Sort for meaningful input sizes. The quadratic term dominates quickly, making Merge Sort superior for any n > 2.

**Graphical Explanation:**
- For small n: Both are fast, difference negligible
- As n grows: n² grows much faster than n log n
- Merge Sort's line (n log n) stays below Mystery Sort's line (n²) for all practical n
- The crossover point, if it exists, is at such small n that it's not practically relevant

