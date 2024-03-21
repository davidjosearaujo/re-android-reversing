// Copyright 2024 David Araújo
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

public class StringBuilder {

    public static void main(String[] args) {
        short[] array = { 32229, 32234, 32224, 32246, 32235, 32237, 32224, 32170, 32237, 32234, 32240, 32225, 32234,
                32240, 32170, 32229, 32231, 32240, 32237, 32235, 32234, 32170, 32209, 32202, 32205, 32202, 32215, 32208,
                32197, 32200, 32200, 32219, 32212, 32197, 32199, 32207, 32197, 32195, 32193, 26613, 26596, 26598, 26606,
                26596, 26594, 26592, 26559, 25271, 25272, 25266, 25252, 25273, 25279, 25266, 25336, 25279, 25272, 25250,
                25267, 25272, 25250, 25336, 25267, 25262, 25250, 25252, 25271, 25336, 25220, 25235, 25218, 25219, 25220,
                25240, 25225, 25220, 25235, 25221, 25219, 25242, 25218 };
        decoder(39, 47, 26501, array);
    }

    private static void decoder(int i, int i2, int i3, short[] arr) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) (arr[i + i4] ^ i3);
        }
        System.out.println(new String(cArr));
    }
}