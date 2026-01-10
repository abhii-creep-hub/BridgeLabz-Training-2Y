# Problem 1: Time Complexity Analysis
## Linear Search vs Binary Search vs Hash Table

### Scenario
A social media platform needs to verify if a username is already taken. The system has 10 million registered users and receives 100,000 username check requests per second during peak hours.

### Solution

#### a) Time Complexity Analysis

**Algorithm A: Linear Search**
- Time Complexity: O(n)
- Worst case: n comparisons (username not found or at the end)
- Best case: 1 comparison (username at first position)
- Average case: n/2 comparisons

**Algorithm B: Binary Search**
- Time Complexity: O(log n)
- Requires sorted array
- Worst case: log₂(n) comparisons
- Best case: 1 comparison
- Average case: log₂(n) comparisons

**Algorithm C: Hash Table Lookup**
- Time Complexity: O(1) average case, O(n) worst case
- Average case: 1 operation (constant time)
- Worst case: O(n) due to hash collisions

#### b) Space Complexity Analysis

**Algorithm A: Linear Search**
- Space Complexity: O(1)
- Only uses constant extra space for variables

**Algorithm B: Binary Search**
- Space Complexity: O(1) iterative, O(log n) recursive
- Uses constant space for variables (iterative implementation)

**Algorithm C: Hash Table Lookup**
- Space Complexity: O(n)
- Requires O(n) space to store the hash table

#### c) Practical Recommendations

For 10 million users and 100,000 requests/second:
- **Hash Table** is best for real-time lookups (O(1) average)
- **Binary Search** is good if data is sorted and memory is limited
- **Linear Search** is not suitable for this scale

#### d) Implementation Considerations

- Hash tables provide fastest lookups but require more memory
- Binary search needs sorted data and has O(log n) complexity
- Linear search is simple but too slow for large datasets

