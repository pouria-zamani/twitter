package util;

public class Menu {
    public void printMainMenu(){
        System.out.println(" 1.Sign up  ");
        System.out.println(" 2.Log in   ");
        System.out.println(" 3.Search all users by username   ");
        System.out.println(" 4.Close    ");
        System.out.println("enter the number:");
    }

    public void printSecondMenu(){
        System.out.println(" 1.Tweets");
        System.out.println(" 2.Comments");
        System.out.println(" 3.Likes");
        System.out.println(" 4.Account");
        System.out.println(" 5.sign out");
        System.out.println(" 6.close");
        System.out.println("enter the number:");
    }

    public void printTweetMenu(){
        System.out.println(" 1.Show All Tweets   ");
        System.out.println(" 2.Show My Tweets   ");
        System.out.println(" 3.Show a Tweet's Properties   ");
        System.out.println(" 4.Add a Tweet    ");
        System.out.println(" 5.Edit a Tweet    ");
        System.out.println(" 6.Delete a Tweet    ");
        System.out.println(" 7.mainMenu");
        System.out.println(" 8.close");
        System.out.println("enter the number:");
    }

    public void printCommentMenu(){
        System.out.println(" 1.Add a Comment on a Tweet");
        System.out.println(" 2.Show my Comment on a Tweet");
        System.out.println(" 3.Edit my Comment on a Tweet");
        System.out.println(" 4.Delete my Comment on a Tweet");
        System.out.println(" 5.mainMenu");
        System.out.println(" 6.close");
        System.out.println("enter the number:");
    }

    public void printLikeMenu(){
        System.out.println(" 1.Add a Like on a Tweet");
        System.out.println(" 2.Reverse my Like on a Tweet");
        System.out.println(" 3.Delete my Like on a Tweet");
        System.out.println(" 4.mainMenu");
        System.out.println(" 5.close");
        System.out.println("enter the number:");
    }

    public void printAccountMenu(){
        System.out.println(" 1.Edit my Account  ");
        System.out.println(" 2.Delete Account   ");
        System.out.println(" 3.mainMenu   ");
        System.out.println(" 4.close   ");
        System.out.println("enter the number:");
    }
}
