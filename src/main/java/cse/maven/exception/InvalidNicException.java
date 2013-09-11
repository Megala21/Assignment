package cse.maven.exception;

public class InvalidNicException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidNicException(String nic)	{
		super("Invalid nic number " + nic +" , please enter a valid number");
	}
}
