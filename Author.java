package bookkeeper;


public class Author implements Comparable<Author>
{
	private String givenName;
	private String familyName;
	private String middleName;
	
	public Author (String familyName, String givenName)
	{
		if (familyName == null || givenName == null)
			throw new IllegalArgumentException();
		this.familyName = familyName;
		this.givenName = givenName;
	}
	public Author (String familyName, String givenName, String middleName)
	{
		if (familyName == null || givenName == null || middleName == null)
			throw new IllegalArgumentException();
		this.familyName = familyName;
		this.givenName = givenName;
		this.middleName = middleName;
	}
	public int compareTo(Author o)
	{
		int fam = this.familyName.compareTo(o.familyName);
		if (fam != 0)
			return fam;
		int given = this.givenName.compareTo(o.givenName);
		if (given != 0)
			return given;
		if (this.middleName == null && o.middleName == null)
			return 0;
		else if (this.middleName == null)
			return -1;
		else if (o.middleName == null)
			return 1;
		else
			return this.middleName.compareTo(o.middleName);
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
	@Override
	public boolean equals(Object o)
	{
		if (o == null)
			return false;
		if (this == o)
			return true;
		if (o instanceof Author)
			return (familyName == ((Author)o).familyName 
				&& givenName == ((Author)o).givenName 
				&& middleName == ((Author)o).middleName);
		return false;
	}
}
