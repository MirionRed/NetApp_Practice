use LWP::UserAgent;
use HTTP::Request;
use HTTP::Response;
use JSON;
use Text::CSV::Slurp;
use Data::Dumper;

my $ua = new LWP::UserAgent;
$ua->agent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.104 Safari/537.36");
my $jsonLink = "http://labs.jamesooi.com/ueen3433-asg.php";
my $request = HTTP::Request->new(GET=>$jsonLink);
my $response = $ua->request($request);

if($response->is_success){
  my $rows = JSON->new->utf8->decode($response->content);

  print Dumper(\$rows);
  $fileName = "inputFile.csv";
  open $fh, ">:encoding(utf8)", $fileName;
  print $fh Text::CSV::Slurp->create(input => \@$rows);
  close $fh;
} else {
  print $response->error;
}
