-- Create User Table
CREATE TABLE User (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    Password VARCHAR(255),
    DateOfBirth DATE,
    Bio TEXT,
    ProfilePicture VARCHAR(255),
    Gender VARCHAR(50),
    Country VARCHAR(100),
    Phone VARCHAR(20)
);

-- Create Friendship Table
CREATE TABLE Friendship (
    FriendshipID INT PRIMARY KEY AUTO_INCREMENT,
    UserID1 INT,
    UserID2 INT,
    Status VARCHAR(50),
    FOREIGN KEY (UserID1) REFERENCES User(UserID),
    FOREIGN KEY (UserID2) REFERENCES User(UserID)
);

-- Create Post Table
CREATE TABLE Post (
    PostID INT PRIMARY KEY AUTO_INCREMENT,
    Content TEXT,
    DateTime DATETIME,
    PostType VARCHAR(50),
    UserID INT,
    GroupID INT NULL,
    FOREIGN KEY (UserID) REFERENCES User(UserID),
    FOREIGN KEY (GroupID) REFERENCES GroupUser(GroupID)
);

-- Create Comment Table
CREATE TABLE Comment (
    CommentID INT PRIMARY KEY AUTO_INCREMENT,
    Content TEXT,
    DateTime DATETIME,
    UserID INT,
    PostID INT,
    FOREIGN KEY (UserID) REFERENCES User(UserID),
    FOREIGN KEY (PostID) REFERENCES Post(PostID)
);

-- Create Reaction Table
CREATE TABLE Reaction (
    ReactionID INT PRIMARY KEY AUTO_INCREMENT,
    Type VARCHAR(50),
    DateTime DATETIME,
    UserID INT,
    PostID INT,
    FOREIGN KEY (UserID) REFERENCES User(UserID),
    FOREIGN KEY (PostID) REFERENCES Post(PostID)
);

-- Create Notification Table
CREATE TABLE Notification (
    NotificationID INT PRIMARY KEY AUTO_INCREMENT,
    Type VARCHAR(50),
    DateTime DATETIME,
    SenderID INT,
    ReceiverID INT,
    FOREIGN KEY (SenderID) REFERENCES User(UserID),
    FOREIGN KEY (ReceiverID) REFERENCES User(UserID)
);

-- Create Message Table
CREATE TABLE Message (
    MessageID INT PRIMARY KEY AUTO_INCREMENT,
    Content TEXT,
    DateTime DATETIME,
    SenderID INT,
    ReceiverID INT,
    FOREIGN KEY (SenderID) REFERENCES User(UserID),
    FOREIGN KEY (ReceiverID) REFERENCES User(UserID)
);

-- Create Group Table
CREATE TABLE GroupUser (
    GroupID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255),
    Description TEXT,
    OwnerID INT,
    FOREIGN KEY (OwnerID) REFERENCES User(UserID)
);

-- Create GroupMembership Table
CREATE TABLE GroupMembership (
    GroupMembershipID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT,
    GroupID INT,
    RoleID INT,
    FOREIGN KEY (UserID) REFERENCES User(UserID),
    FOREIGN KEY (GroupID) REFERENCES GroupUser(GroupID),
    FOREIGN KEY (RoleID) REFERENCES GroupRole(GroupRoleID)
);

-- Create GroupRole Table
CREATE TABLE GroupRole (
    GroupRoleID INT PRIMARY KEY AUTO_INCREMENT,
    RoleName VARCHAR(50)
);

-- Queries to see data in each table
SELECT * FROM User;
SELECT * FROM Friendship;
SELECT * FROM Post;
SELECT * FROM Comment;
SELECT * FROM Reaction;
SELECT * FROM Notification;
SELECT * FROM Message;
SELECT * FROM GroupUser;
SELECT * FROM GroupMembership;
SELECT * FROM GroupRole;
