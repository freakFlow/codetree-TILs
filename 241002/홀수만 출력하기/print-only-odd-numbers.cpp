#include <iostream>
using namespace std;

int main() {
    int N;

    cin >> N;

    for(int i=0; i<N; i++){
        int num;
        cin >> num;

        if(num % 2 == 1 && num % 3 == 0) cout << num << endl;
    }

    return 0;
}