#include <bits/stdc++.h>
using namespace std;
using ll = long long;

// Competitive programming divisors: returns all divisors of n in ascending order.
// Complexity: O(sqrt(n)).

vector<ll> divisors(ll n, bool proper = false) {
    vector<ll> d;
    for (ll i = 1; i * i <= n; ++i) {
        if (n % i == 0) {
            ll a = i, b = n / i;
            if (proper && a == n) continue; // skip n itself if proper divisors requested
            d.push_back(a);
            if (b != a) {
                if (!(proper && b == n)) d.push_back(b);
            }
        }
    }
    sort(d.begin(), d.end());
    return d;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long n;
    if (!(cin >> n)) return 0;

    // By default returns all divisors including n and 1. To get proper divisors set proper = true.
    auto d = divisors(n, /*proper=*/false);
    for (size_t i = 0; i < d.size(); ++i) {
        if (i) cout << ' ';
        cout << d[i];
    }
    cout << '\n';
    return 0;
}
