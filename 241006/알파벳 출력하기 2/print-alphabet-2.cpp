#include <iostream>
using namespace std;

int main() {
    int N;

    cin >> N;

    char ch = 'A';

    for(int i=0; i<N; i++){
        for(int j=0; j<i; j++){
            cout << "  ";
        }
        for(int j=0; j<N-i; j++){
            cout << ch++ << ' ';
            if(ch > 'Z') ch = 'A';
        }
        cout << endl;
    }

    return 0;
}