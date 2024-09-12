#include <iostream>
using namespace std;

int main() {
    int m_a, e_a, m_b, e_b;

    cin >> m_a >> e_a >> m_b >> e_b;

    cout << (m_a > m_b && e_a > e_b);

    return 0;
}