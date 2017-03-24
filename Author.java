package bookkeeper;


public class Author implements Comparable<Author>
{
	private String givenName;
	private String familyName;
	private String middleName;
	
	public Author(){}
	public Author (String familyName, String givenName)
	{
		this.familyName = familyName;
		this.givenName = givenName;
	}
	public int compareTo(Author o)
	{
		int fam = this.familyName.compareTo(o.familyName);
		if (fam != 0)
			return fam;
		int given = this.givenName.compareTo(o.givenName);
		if (given != 0)
			return given;
		int mid = this.middleName.compareTo(o.middleName);
		if (mid != 0)
			return mid;
		return 0;
	}
	@Override
	public String toString()
	{
		StringBuilder sb = (new StringBuilder())
				.append(familyName)
				.append(", ")
				.append(givenName);
		if (middleName != null)
			sb.append(" ").append(middleName);
		return sb.toString();
	}
}
