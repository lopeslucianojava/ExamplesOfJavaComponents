package test.binary.read;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;


/*
 * @(#)DataInputStream.java		(18/04/2022)
 *
 *
 *
 */
public class DataExInputStream extends DataInputStream {

	public DataExInputStream(InputStream in) {
		super(in);
	}

	/**
	 * Le um valor binario sem sinal do tamanho de um byte (0 - 255)
	 * 
	 * @throws IOException
	 * @throws EOFReachedException
	 */
	public int read1Byte() throws IOException {
		byte[] b = new byte[1];
		if (read(b) != 1) {
			throw new EOFException();
		}

		int resposta = b[0] & 0xFF;
		return resposta;
	}

	/**
	 * Le um valor binario sem sinal do tamanho de dois bytes (0 - 65535)
	 * 
	 * @throws EOFReachedException
	 */
	public int read2Bytes() throws IOException, EOFException {
		byte[] b = new byte[2];
		if (read(b) != 2) {
			throw new EOFException();
		}

		int resposta = 0;
		resposta = ((int) (b[0] & 0xFF)) << 8;
		resposta += ((int) (b[1] & 0xFF));

		return resposta;
	}

	/**
	 * Le um valor binario sem sinal do tamanho de tres bytes (0 - 16777215)
	 * 
	 * @throws EOFReachedException
	 */
	public int read3Bytes() throws IOException, EOFException {
		byte[] b = new byte[3];
		if (read(b) != 3) {
			throw new EOFException();
		}

		int resposta = 0;
		resposta = (((int) (b[0] & 0xFF)) << 16);
		resposta += (((int) (b[1] & 0xFF)) << 8);
		resposta += ((int) (b[2] & 0xFF));
		
		return resposta;
	}

	/**
	 * Le um valor binario sem sinal do tamanho de quatro bytes (0 - 4294967295)
	 * 
	 * @throws EOFReachedException
	 */
	public long read4Bytes() throws IOException, EOFException {
		byte[] b = new byte[4];
		if (read(b) != 4) {
			throw new EOFException();
		}
		
		long resposta = 0L;
		
		resposta = ((long) (b[0] & 0xFF)) << 24;
		resposta += ((long) (b[1] & 0xFF)) << 16;
		resposta += ((long) (b[2] & 0xFF)) << 8;
		resposta += ((long) (b[3] & 0xFF));

		/**long resposta = (((b[0] & 0xFF) << 24) | ((b[1] & 0xFF) << 16)
				| ((b[2] & 0xFF) << 8) | (b[3] & 0xFF));*/
		return resposta;
	}
	
	/**
	 * Faz a leitura de número de forma Signed (Com Sinal)
	 * 
	 * @return
	 * @throws IOException
	 * @throws EOFException
	 */
	public long readSigned4Bytes() throws IOException, EOFException {
		byte[] b = new byte[4];
		if (read(b) != 4) {
			throw new EOFException();
		}

		long resposta = (((b[0] & 0xFF) << 24) | ((b[1] & 0xFF) << 16)
				| ((b[2] & 0xFF) << 8) | (b[3] & 0xFF));
		return resposta;
	}

	/**
	 * Le um valor binario sem sinal do tamanho de cinco bytes (0 - 2^40)
	 * 
	 * @throws EOFReachedException
	 */
	public long read5Bytes() throws IOException, EOFException {
		byte[] b = new byte[5];
		if (read(b) != 5) {
			throw new EOFException();
		}

		long resposta = 0L;
		
		resposta = ((long) (b[0] & 0xFF)) << 32;
		resposta += ((long) (b[1] & 0xFF)) << 24;
		resposta += ((long) (b[2] & 0xFF)) << 16;
		resposta += ((long) (b[3] & 0xFF)) << 8;
		resposta += ((long) (b[4] & 0xFF));

		return resposta;
	}

	/**
	 * Le um valor binario sem sinal do tamanho de oito bytes em Big-Endian.
	 * 
	 * @throws EOFReachedException
	 */
	public long read8Bytes() throws IOException, EOFException {
		byte[] b = new byte[8];
		if (read(b) != b.length) {
			throw new EOFException();
		}

		long resposta = 0L;
		
		resposta = ((long) (b[0] & 0xFF)) << 56;
		resposta += ((long) (b[1] & 0xFF)) << 48;
		resposta += ((long) (b[2] & 0xFF)) << 40;
		resposta += ((long) (b[3] & 0xFF)) << 32;
		resposta += ((long) (b[4] & 0xFF)) << 24;
		resposta += ((long) (b[5] & 0xFF)) << 16;
		resposta += ((long) (b[6] & 0xFF)) << 8;
		resposta += ((long) (b[7] & 0xFF));
		
		return resposta;
	}
	
	/**
	 * Le uma String de tamanho determinado pelo parametro
	 * 
	 * @throws EOFReachedException
	 */
	public String readString(int tamanhoCampos) throws IOException,
			EOFException {
		byte[] b = new byte[tamanhoCampos];
		if (read(b) != tamanhoCampos) {
			throw new EOFException();
		}

		String resposta = new String(b);
		return resposta;
	}
}
