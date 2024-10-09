#include <iostream>
#include <string>
using namespace std;

int main() {
    string str;
    char alpha[1000];
    int count[1000];
    int len = 0, idx = 0;

    cin >> str;

    char ch = str[0];
    int cnt = 1;

    for(int i=1; i<str.length(); i++){
        if(str[i] == ch){
            cnt++;
            continue;
        }

        alpha[idx] = ch;
        count[idx++] = cnt;

        if(cnt >= 1000) len++;
        if(cnt >= 100) len++;
        if(cnt >= 10) len++;
        len += 2;

        ch = str[i];
        cnt = 1; 
    }

    alpha[idx] = ch;
    count[idx++] = cnt;

    if(cnt >= 1000) len++;
    if(cnt >= 100) len++;
    if(cnt >= 10) len++;
    len += 2;

    cout << len << endl;

    for(int i=0; i<idx; i++){
        cout << alpha[i] << count[i];
    }

    return 0;
}