#include <bits/stdc++.h>
using namespace std;

// Modern, compact BFS suitable for competitive programming (C++23)
// Reads a directed graph (n, m) followed by m edges (0-based by default),
// runs BFS from source s (default 0) and prints distances (-1 = unreachable).

pair<vector<int>, vector<int>> bfs(const vector<vector<int>>& g, int s) {
    int n = (int)g.size();
    vector<int> dist(n, -1), pred(n, -1);
    queue<int> q;
    dist[s] = 0;
    q.push(s);
    while (!q.empty()) {
        int u = q.front(); q.pop();
        for (int v : g[u]) {
            if (dist[v] == -1) {
                dist[v] = dist[u] + 1;
                pred[v] = u;
                q.push(v);
            }
        }
    }
    return {dist, pred};
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    if (!(cin >> n >> m)) return 0;
    vector<vector<int>> g(n);
    for (int i = 0; i < m; ++i) {
        int u, v; cin >> u >> v;
        // If input is 1-based, uncomment: // --u; --v;
        g[u].push_back(v);
        // For undirected graphs also add: // g[v].push_back(u);
    }

    int s = 0; // change source if needed or read from input
    auto [dist, pred] = bfs(g, s);

    // Output distances: index: distance
    for (int i = 0; i < n; ++i) cout << i << ": " << dist[i] << '\n';

    return 0;
}
