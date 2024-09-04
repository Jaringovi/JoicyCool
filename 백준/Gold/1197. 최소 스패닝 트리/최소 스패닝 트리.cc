#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

const int maxV = 10004;
const int maxE = 100004;
int V, E, A, B, C;

int parents[maxV];

class Edge {
public:
    int start, end, weight;
    Edge(int start, int end, int weight) {
        this->start = start;
        this->end = end;
        this->weight = weight;
    }
};

bool cmp(Edge a, Edge b) {
    return a.weight < b.weight;
}

void make() {
    for (int i = 0; i < maxV; i++) {
        parents[i] = i;
    }
}

int findSet(int a) {
    if (parents[a] == a) return a;
    return parents[a] = findSet(parents[a]);
}


bool unionFun(int a, int b) {
    int aRoot = findSet(a);
    int bRoot = findSet(b);

    if (aRoot == bRoot) return false;
    if (aRoot < bRoot) {
        parents[aRoot] = parents[bRoot];
    }
    else {
        parents[bRoot] = parents[aRoot];
    }
    return true;
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<Edge> vec;
    make();
    cin >> V >> E;
    for (int i = 0; i < E; i++) {
        cin >> A >> B >> C;
        vec.push_back(Edge(A, B, C));
    }

    sort(vec.begin(), vec.end(), cmp);
    int cnt = 0; int cost = 0;
    for (Edge edge: vec) {
        if (unionFun(edge.start, edge.end)) {
            cost += edge.weight;
            cnt++;
            if (cnt == V - 1)break;
        }
    }
    cout << cost;
 
    return 0;
}
