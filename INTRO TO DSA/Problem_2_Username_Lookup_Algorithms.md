# Problem 2: Time Complexity Analysis - Username Lookup Algorithms

### Scenario
A platform needs to find a username in a list of 10 million users using three different algorithms.

### Solutions

#### a) Exact Number of Operations (Worst Case)

**Algorithm A: Linear Search**
- Worst case operations: n = 10,000,000 comparisons
- The algorithm checks each element sequentially until found or end of list

**Algorithm B: Binary Search**
- Worst case operations: log₂(10,000,000) ≈ 23.25 ≈ 24 comparisons
- Calculation: log₂(10⁷) = 7 × log₂(10) ≈ 7 × 3.32 ≈ 23.25

**Algorithm C: Hash Table Lookup**
- Worst case operations: O(n) = 10,000,000 (in case of all collisions)
- Average case: 1 operation (assuming good hash function)

#### b) Time Complexity in Big-O Notation

**Algorithm A: Linear Search**
- Time Complexity: O(n)
- Justification: In worst case, we examine all n elements once

**Algorithm B: Binary Search**
- Time Complexity: O(log n)
- Justification: Each step eliminates half the search space, requiring log₂(n) steps

**Algorithm C: Hash Table Lookup**
- Time Complexity: O(1) average, O(n) worst case
- Justification: Hash function computes index directly; collisions can degrade to O(n)

#### c) Comparison Table

| n | Linear Search | Binary Search | Hash Table (avg) |
|---|---------------|---------------|------------------|
| 100 | 100 | 7 | 1 |
| 1,000 | 1,000 | 10 | 1 |
| 10,000 | 10,000 | 14 | 1 |
| 100,000 | 100,000 | 17 | 1 |
| 1,000,000 | 1,000,000 | 20 | 1 |
| 10,000,000 | 10,000,000 | 24 | 1 |

**Patterns Observed:**
- Linear search grows linearly with n
- Binary search grows logarithmically (much slower growth)
- Hash table remains constant (best performance)

#### d) Time Calculation for 50,000 Checks/Second

Assuming each comparison takes 1 nanosecond:

**Algorithm A: Linear Search**
- Operations per check: 10,000,000
- Time per check: 10,000,000 ns = 10 ms
- Time for 50,000 checks: 50,000 × 10 ms = 500,000 ms = 500 seconds

**Algorithm B: Binary Search**
- Operations per check: 24
- Time per check: 24 ns
- Time for 50,000 checks: 50,000 × 24 ns = 1,200,000 ns = 1.2 ms

**Algorithm C: Hash Table**
- Operations per check: 1 (average)
- Time per check: 1 ns
- Time for 50,000 checks: 50,000 × 1 ns = 50,000 ns = 0.05 ms

**Conclusion:** Only Binary Search and Hash Table can handle this load. Linear Search is too slow.

#### e) When to Sort and Use Binary Search

Let k = number of searches
Sorting cost: O(n log n) = n log₂(n) operations
Linear search cost per search: n operations
Binary search cost per search: log₂(n) operations

Total cost with sorting: n log₂(n) + k × log₂(n)
Total cost without sorting: k × n

We should sort when: n log₂(n) + k × log₂(n) < k × n

Solving: n log₂(n) < k(n - log₂(n))
k > n log₂(n) / (n - log₂(n))

For large n, this approximates to: k > log₂(n)

For n = 10,000,000: k > 24 searches

If we perform more than 24 searches, it's worthwhile to sort once and use binary search.

