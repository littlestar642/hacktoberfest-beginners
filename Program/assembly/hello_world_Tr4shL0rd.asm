; helloWorld.asm
; Syscall file: /usr/include/asm/unistd_32.h 
;
; Author: Tr4shL0rd
; date:   02/10/21
;
; Compile:
;   nasm -f elf32 -o helloWorld.o helloWorld.asm
;   ld -m elf_i386 -o helloWorld helloWorld.o 
;
;

global _start

section .text:

_start:
  mov eax, 0x4                     ; use the write syscall
  mov ebx, 1                       ; use stdout as the fd
  mov ecx, message                 ; use the message as the buffer
  mov edx, messageLength           ; and supply the messageLength
  int 0x80                         ; invoke syscall

  ; exit gracefully

  mov eax, 0x1
  mov ebx, 0
  int 0x80

section .data:
  message: db "Hello World!", 0xA ; defines variable message and appends newline charater 0xA   
  messageLength equ $-message     ; defines variable messageLength 
