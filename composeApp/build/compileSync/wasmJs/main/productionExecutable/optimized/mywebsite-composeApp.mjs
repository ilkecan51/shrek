
import { instantiate } from './mywebsite-composeApp.uninstantiated.mjs';


const exports = (await instantiate({
})).exports;

export const {
memory,
_initialize
} = exports


