# Problem 3: Space Complexity and Space-Time Tradeoffs

### Scenario
An e-learning platform needs to check if a student has completed all prerequisite courses before allowing enrollment in an advanced course.

### Solutions

#### a) Time Complexity Analysis

**Implementation A: Nested Loop**
- Outer loop: m iterations (prerequisites)
- Inner loop: n iterations (completed courses) in worst case
- Time Complexity: O(m × n)
- In worst case, for each prerequisite, we check all completed courses

**Implementation B: Hash Set**
- First loop: n iterations to build hash set
- Second loop: m iterations to check prerequisites
- Hash set lookup: O(1) average case
- Time Complexity: O(n + m)
- Building hash set takes O(n), checking takes O(m)

#### b) Space Complexity Analysis

**Implementation A: Nested Loop**
- Auxiliary Space: O(1)
- Only uses constant space for loop variables and flags

**Implementation B: Hash Set**
- Auxiliary Space: O(n)
- Requires space to store n completed courses in hash set
- Each entry typically uses 8-16 bytes (depending on implementation)

#### c) Calculations for Typical Scenario

Given: n = 40 completed courses, m = 5 prerequisites, 100,000 students/day

**Implementation A:**
- Comparisons per check: m × n = 5 × 40 = 200 comparisons
- Total comparisons per day: 100,000 × 200 = 20,000,000 comparisons

**Implementation B:**
- Memory per check: n × 8 bytes = 40 × 8 = 320 bytes
- Total memory per day: 100,000 × 320 bytes = 32,000,000 bytes = 32 MB

#### d) Infrastructure Constraints Analysis

Given constraints:
- Response time < 10ms per check
- Memory < 1GB for 10,000 concurrent requests
- Each comparison takes 0.1 microseconds

**Implementation A:**
- Time per check: 200 comparisons × 0.1 μs = 20 μs = 0.02 ms ✓ (meets requirement)
- Memory per check: ~0 bytes (negligible)
- Total memory for 10,000 requests: ~0 MB ✓ (meets requirement)

**Implementation B:**
- Time per check: (40 + 5) × 0.1 μs = 4.5 μs = 0.0045 ms ✓ (meets requirement)
- Memory per check: 320 bytes
- Total memory for 10,000 requests: 10,000 × 320 bytes = 3,200,000 bytes = 3.2 MB ✓ (meets requirement)

Both implementations meet the constraints. However, Implementation B is faster and uses minimal memory.

#### e) Hybrid Approach

**Strategy for small m (1-2 prerequisites):**
- Use Implementation A (nested loop)
- When m is very small, the overhead of building hash set isn't worth it
- Threshold: m ≤ 2

**Strategy for large m (20+ prerequisites):**
- Use Implementation B (hash set)
- When m is large, hash set lookup becomes more efficient
- Threshold: m > 2

**Mathematical Threshold:**
We switch when: O(m × n) > O(n + m)
This occurs when: m × n > n + m
Solving: m × n - m > n
m(n - 1) > n
m > n/(n - 1)

For n = 40: m > 40/39 ≈ 1.03

So we switch to hash set when m > 1.03, meaning for m ≥ 2, use hash set approach.

**Conclusion:**
- For m = 1: Use nested loop (simpler, no overhead)
- For m ≥ 2: Use hash set (more efficient)

