#include <iostream>
using namespace std;

int main() {
    int math_a, eng_a, math_b, eng_b;

    cin >> math_a >> eng_a >> math_b >> eng_b;

    if(math_a == math_b) cout << (eng_a > eng_b ? 'A' : 'B');
    else cout << (math_a > math_b ? 'A' : 'B');

    return 0;
}