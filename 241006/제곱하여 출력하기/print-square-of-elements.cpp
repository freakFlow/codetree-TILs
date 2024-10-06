#include <iostream>
using namespace std;

int main() {
    int n;
    int num;

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> num;
        cout << num * num << ' ';
    }

    return 0;
}