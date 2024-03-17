// Copyright 2024 David Araújo
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//     http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

public class chineseDeofuscator {

    public static void main(String[] args) {
        System.out.println("wmvpsjylkomjunuemnomk: " + chineseStringToPackageName("恊恆恛思恋恅恆恚恙恅恊思恘恙恞恊恆恚恚恄恞思恙恄恘恊恚恆恆", 2));
        System.out.println("odvoepqvervhrhwpxpun: " + chineseStringToPackageName("恅恂恁", 2));
        System.out.println("erslvlhdhwyiqi: " + chineseStringToPackageName("恚恆恔恘恖", 2));
        System.out.println("ifqsrmoxkldsotk: " + chineseStringToPackageName("恁恋恁恙恚恊", 2));
        System.out.println("rytluexmqwrmyvnlrle: " + chineseStringToPackageName("恇恙恃", 2));
        System.out.println("nvoyhpvsvfsr: " +chineseStringToPackageName("恐恜恞思恉恙恋恊恋恝恅恅恃思恝恋恅恋恐恛恟恇恕", 2));
        System.out.println("uvxtulgtnpojqhjnxmexm: " + chineseStringToPackageName("恃恛恇思恗恔恁恁恀恁恃思恛恔恗恇恔恀恀恅恄思恛恖恖恆恇恗恆恇恛恘恊恖恛恃恘恟恛恄恜恋", 2));
        System.out.println("notkmygjwgpqutdlsejxp: " + chineseStringToPackageName("", 2));
        System.out.println("ehsqpiefmxd: " + chineseStringToPackageName("捨뺑戚\\ue684聳踖曡㒕躚\\udafdﶃ킎", 2));
    }

    public static String chineseStringToPackageName(String str, int i) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                stringBuilder
                        .append((char) (str.charAt(j) ^ obfuscatorTranslator(i)[j % obfuscatorTranslator(i).length]));
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: a */
    private static char[] obfuscatorTranslator(int i) {
        switch (i) {
            case 0:
                return new char[] { 37469, 12893, 58265, 34626, 61595, 5235, 30980, 36330, 54953, 54553, 35458, 50593 };
            case 1:
                return new char[] { 12293, 12294 };
            case 2:
                return new char[] { 24627 };
            case 3:
                return new char[] { ',', 'w', 65532, 180, 65480, 178, 'K', 131, 'r', 'A', '}', 139, 133, 193, '\f', 169,
                        'O', 172, 139, '8', 17, 'D', ')', 'z', ']', 198, 228, 'W', 179, 142, 65524, 161, 65515, '0',
                        134, 143, 31, 65526, 172, 203, 'Y', 65519, 203, 't', ' ', 65528, '8', 183, 213, 'U', 'o', 65500,
                        's', 27, 21, '1', '.', 'z', '*', 141, '+', '\\', 'm', 11, 149, '9', '<', 'r', 220, 144, 181,
                        194, 169, 'j', 65520 };
            default:
                return new char[0];
        }
    }

}