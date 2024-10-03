#include <iostream>
using namespace std;

int main() {
    int width, height;
    char ch;

    while(true){
        cin >> width >> height >> ch;

        cout << width * height << endl;

        if(ch == 'C') break;
    }

    return 0;
}