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
        short[] array = {7230, 7228, 7211, 7222, 7209, 7222, 7211, 7206};
        decoder(0, array.length, 7263, array);
    }

    private static void decoder(int i, int i2, int i3, short[] arr) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) (arr[i + i4] ^ i3);
        }
        System.out.println(new String(cArr));
    }
}