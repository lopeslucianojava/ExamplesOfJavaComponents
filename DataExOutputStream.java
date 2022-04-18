package test.binary.write;

import java.io.DataOutputStream;
import java.io.OutputStream;

/*
 * @(#)DataExOutputStream.java		(18/04/2022)
 *
 *
 *
 */
public class DataExOutputStream extends DataOutputStream {

	public DataExOutputStream(OutputStream out) {
		super(out);
	}

	/**
	 * Escreve um valor binario sem sinal do tamanho de um byte (0 - 255)
	 */
	public void write1Byte(int data) throws Exception {
		byte[] b = new byte[1];
		b[0] = (byte) (data & 0xFF);
		write(b, 0, b.length);
	}

	/**
	 * Escreve um valor binario sem sinal do tamanho de um byte (0 - 255)
	 */
	public void write1Byte(long data) throws Exception {
		byte[] b = new byte[1];
		b[0] = (byte) (data & 0xFF);
		write(b, 0, b.length);
	}

	/**
	 * Escreve um valor binario sem sinal do tamanho de dois bytes (0 - 65535)
	 */
	public void write2Bytes(int data) throws Exception {
		byte[] b = new byte[2];

		b[0] = (byte) ((data & 0xFF00) >> 8);
		b[1] = (byte) (data & 0xFF);

		write(b, 0, b.length);
	}

	/**
	 * Escreve um valor binario sem sinal do tamanho de dois bytes (0 - 65535)
	 */
	public void write2Bytes(long data) throws Exception {
		byte[] b = new byte[2];

		b[0] = (byte) ((data & 0xFF00) >> 8);
		b[1] = (byte) (data & 0xFF);

		write(b, 0, b.length);
	}

	/**
	 * Escreve um valor binario sem sinal do tamanho de tres bytes (0 - 16777215)
	 */
	public void write3Bytes(int data) throws Exception {
		byte[] b = new byte[3];

		b[0] = (byte) ((data & 0xFF0000) >> 16);
		b[1] = (byte) ((data & 0xFF00) >> 8);
		b[2] = (byte) (data & 0xFF);

		write(b, 0, b.length);
	}

	/**
	 * Escreve um valor binario sem sinal do tamanho de tres bytes (0 - 16777215)
	 * 
	 */
	public void write3Bytes(long data) throws Exception {
		byte[] b = new byte[3];

		b[0] = (byte) ((data & 0xFF0000) >> 16);
		b[1] = (byte) ((data & 0xFF00) >> 8);
		b[2] = (byte) (data & 0xFF);

		write(b, 0, b.length);
	}

	/**
	 * Escreve um valor binario sem sinal do tamanho de quatro bytes (0 - 4294967295)
	 * 
	 */
	public void write4Bytes(long data) throws Exception {
		byte[] b = new byte[4];

		b[0] = (byte) ((data & 0xFF000000) >> 24);
		b[1] = (byte) ((data & 0xFF0000) >> 16);
		b[2] = (byte) ((data & 0xFF00) >> 8);
		b[3] = (byte) (data & 0xFF);

		write(b, 0, b.length);
	}

	/**
	 * Le uma String de tamanho determinado pelo parametro
	 */
	public void writeString(String data) throws Exception {
		writeBytes(data);
	}

}
