package com.ilkehur.mywebsite

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform