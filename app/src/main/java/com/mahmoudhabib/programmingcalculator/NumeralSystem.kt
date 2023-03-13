package com.mahmoudhabib.programmingcalculator


sealed class NumeralSystem {
    abstract fun toHex(num: Int): String
    abstract fun toDec(num: Int): String
    abstract fun toOct(num: Int): String
    abstract fun toBin(num: Int): String

    object HexadecimalSystem : NumeralSystem() {
        override fun toHex(num: Int): String {
            return Integer.toHexString(num)
        }

        override fun toDec(num: Int): String {
            return num.toString()
        }

        override fun toOct(num: Int): String {
            return Integer.toOctalString(num)
        }

        override fun toBin(num: Int): String {
            return Integer.toBinaryString(num)
        }
    }

    object DecimalSystem : NumeralSystem() {
        override fun toHex(num: Int): String {
            return Integer.toHexString(num)
        }

        override fun toDec(num: Int): String {
            return num.toString()
        }

        override fun toOct(num: Int): String {
            return Integer.toOctalString(num)
        }

        override fun toBin(num: Int): String {
            return Integer.toBinaryString(num)
        }
    }

    object OctalSystem : NumeralSystem() {
        override fun toHex(num: Int): String {
            return Integer.toHexString(num)
        }

        override fun toDec(num: Int): String {
            return num.toString()
        }

        override fun toOct(num: Int): String {
            return Integer.toOctalString(num)
        }

        override fun toBin(num: Int): String {
            return Integer.toBinaryString(num)
        }
    }

    object BinarySystem : NumeralSystem() {
        override fun toHex(num: Int): String {
            return Integer.toHexString(num)
        }

        override fun toDec(num: Int): String {
            return num.toString()
        }

        override fun toOct(num: Int): String {
            return Integer.toOctalString(num)
        }

        override fun toBin(num: Int): String {
            return Integer.toBinaryString(num)
        }
    }
}


