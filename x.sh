#!/usr/bin/env bash

export RANLIB=/Users/cgqaq/Library/Android/sdk/ndk/26.1.10909125/toolchains/llvm/prebuilt/darwin-x86_64/bin/llvm-ranlib

export RUST_ANDROID_GRADLE_PYTHON_COMMAND="/usr/bin/python3"
export RUST_ANDROID_GRADLE_CARGO_COMMAND="$HOME/.cargo/bin/cargo"
export RUST_ANDROID_GRADLE_RUSTC_COMMAND="$HOME/.cargo/bin/rustc"
#
#rustup target add aarch64-apple-darwin
#rustup target add x86_64-apple-darwin

rustup target add aarch64-linux-android
rustup target add x86_64-linux-android
rustup target add i686-linux-android
rustup target add armv7-linux-androideabi

./gradlew cargoBuild