#include <iostream>
using namespace std;

int main() {
    int n;
    int count[10] = {};

    cin >> n;

    for(int i=0; i<n; i++){
        int num;
        cin >> num;
        count[num]++;
    }

    for(int i=1; i<10; i++){
        cout << count[i] << endl;
    }

    return 0;
}