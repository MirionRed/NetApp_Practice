my $num_args = $#ARGV + 1;
if($num_args != 1){
  print "\nUsage: saveWebPage.pl url\n";
  exit;
}
my $url = $ARGV[0];

use LWP::UserAgent;
my $ua = LWP::UserAgent->new;
$ua->agent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.104 Safari/537.36");

my $req = HTTP::Request->new(GET => $url);
my $res = $ua->request($req);

if($res->is_success){
  my @filename_parts = split('/', $url);
  my $filename = $filename_parts[$#filename_parts];
  $fileNameName = "savedWeb.txt";
  open(FH,">$fileNameName");
  binmode(FH);
  print FH $res->content;
  close (FH);
  print "Done\n" . $fileNameName;
} else {
  print $res->status_line, "\n";
}
