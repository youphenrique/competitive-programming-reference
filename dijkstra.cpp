#include <bits/stdc++.h>
using namespace std;

// Modern Dijkstra for competitive programming (C++23)
// Reads n m followed by m edges: u v w (0-based by default).
// Outputs distances from source s (default 0), and keeps predecessors for path reconstruction.

using ll = long long;
const ll INF = (1LL<<60);

pair<vector<ll>, vector<int>> dijkstra(const vector<vector<pair<int,ll>>>& g, int s) {
    int n = (int)g.size();
    vector<ll> dist(n, INF);
    vector<int> pred(n, -1);
    dist[s] = 0;
    priority_queue<pair<ll,int>, vector<pair<ll,int>>, greater<>> pq;
    pq.push({0, s});
    while(!pq.empty()){
        auto [d,u] = pq.top(); pq.pop();
        if (d != dist[u]) continue;
        for (auto [v, w] : g[u]){
            if (dist[u] + w < dist[v]){
                dist[v] = dist[u] + w;
                pred[v] = u;
                pq.push({dist[v], v});
            }
        }
    }
    return {dist, pred};
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    if (!(cin >> n >> m)) return 0;
    vector<vector<pair<int,ll>>> g(n);
    for (int i = 0; i < m; ++i){
        int u, v; ll w; cin >> u >> v >> w;
        // If input is 1-based: // --u; --v;
        g[u].push_back({v, w});
        // For undirected graphs: // g[v].push_back({u, w});
    }

    int s = 0; // change or read from input
    auto [dist, pred] = dijkstra(g, s);

    for (int i = 0; i < n; ++i){
        if (dist[i] >= INF/2) cout << i << ": " << -1 << '\n';
        else cout << i << ": " << dist[i] << '\n';
    }

    return 0;
}
