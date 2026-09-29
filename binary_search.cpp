// Modern C++23 competitive programming version of binary search
// - Self-contained example
// - Assumptions: input is 0-based index arrays; prints index or -1 if not found
// Input format (example):
// n
// a1 a2 ... an
// q
// x1
// x2
// ...

#include <bits/stdc++.h>
using namespace std;

// Returns index of any occurrence of 'key' in sorted array 'a', or -1 if not found.
// O(log n), 0-based index.
template<typename T>
int binary_search_idx(const vector<T>& a, const T& key) {
    int l = 0, r = (int)a.size() - 1;
    while (l <= r) {
        int m = l + (r - l) / 2;
        if (a[m] == key) return m;
        if (a[m] < key) l = m + 1;
        else r = m - 1;
    }
    return -1;
}

// Returns first index i such that a[i] >= key (lower_bound behavior). If none, returns a.size().
template<typename T>
int lower_bound_idx(const vector<T>& a, const T& key) {
    int l = 0, r = (int)a.size(); // search in [0, n]
    while (l < r) {
        int m = l + (r - l) / 2;
        if (a[m] < key) l = m + 1;
        else r = m;
    }
    return l;
}

// Returns first index i such that a[i] > key (upper_bound behavior). If none, returns a.size().
template<typename T>
int upper_bound_idx(const vector<T>& a, const T& key) {
    int l = 0, r = (int)a.size();
    while (l < r) {
        int m = l + (r - l) / 2;
        if (a[m] <= key) l = m + 1;
        else r = m;
    }
    return l;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    if (!(cin >> n)) {
        // No input provided: run a small demo
        vector<int> demo = {50,20,60,40,10,30};
        sort(demo.begin(), demo.end());
        int key = 40;
        cout << "demo array (sorted): ";
        for (int x : demo) cout << x << ' ';
        cout << '\n';
        cout << "binary_search_idx(" << key << ") = " << binary_search_idx(demo, key) << '\n';
        cout << "lower_bound_idx(" << key << ") = " << lower_bound_idx(demo, key) << '\n';
        cout << "upper_bound_idx(" << key << ") = " << upper_bound_idx(demo, key) << '\n';
        return 0;
    }

    vector<long long> a(n);
    for (int i = 0; i < n; ++i) cin >> a[i];
    sort(a.begin(), a.end());

    int q; cin >> q;
    while (q--) {
        long long x; cin >> x;
        int idx = binary_search_idx(a, x);
        cout << idx << '\n'; // prints -1 if not found
    }

    return 0;
}
